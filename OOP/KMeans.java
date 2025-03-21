import java.io.*;
import java.util.*;

public class KMeans {

    // 样本数据类
    static class Sample {
        double sepalLength;
        double sepalWidth;
        double petalLength;
        double petalWidth;
        int clusterLabel = -1;  // 聚类标签（初始化为-1）

        public Sample(double sepalLength, double sepalWidth, double petalLength, double petalWidth) {
            this.sepalLength = sepalLength;
            this.sepalWidth = sepalWidth;
            this.petalLength = petalLength;
            this.petalWidth = petalWidth;
        }

        public double[] getFeatures() {
            return new double[]{sepalLength, sepalWidth, petalLength, petalWidth};
        }

        @Override
        public String toString() {
            return sepalLength + "," + sepalWidth + "," + petalLength + "," + petalWidth + "," + clusterLabel;
        }
    }

    // 聚类中心类
    static class Centroid {
        double sepalLength;
        double sepalWidth;
        double petalLength;
        double petalWidth;

        public Centroid(double sepalLength, double sepalWidth, double petalLength, double petalWidth) {
            this.sepalLength = sepalLength;
            this.sepalWidth = sepalWidth;
            this.petalLength = petalLength;
            this.petalWidth = petalWidth;
        }

        public double[] getCoordinates() {
            return new double[]{sepalLength, sepalWidth, petalLength, petalWidth};
        }

        @Override
        public String toString() {
            return "(" + sepalLength + "," + sepalWidth + "," + petalLength + "," + petalWidth + ")";
        }
    }

    // 使用欧氏距离计算两个向量间的距离
    public static double euclideanDistance(double[] a, double[] b) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            double d = a[i] - b[i];
            sum += d * d;
        }
        return Math.sqrt(sum);
    }

    // 从文件中读取数据
    public static List<Sample> readIrisSamples(String filename) {
        List<Sample> samples = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 忽略空行
                if (line.trim().isEmpty()) {
                    continue;
                }
                // 文件中以逗号分隔各个属性
                String[] parts = line.split(",");
                // 检查是否至少有 4 个数值 (忽略原类别)
                if (parts.length < 4) continue;
                double sepalLength = Double.parseDouble(parts[0]);
                double sepalWidth = Double.parseDouble(parts[1]);
                double petalLength = Double.parseDouble(parts[2]);
                double petalWidth = Double.parseDouble(parts[3]);
                samples.add(new Sample(sepalLength, sepalWidth, petalLength, petalWidth));
            }
        } catch (IOException e) {
            System.err.println("读取文件出错: " + e.getMessage());
        }
        return samples;
    }

    // 随机初始化 K 个聚类中心
    public static List<Centroid> initializeCentroids(List<Sample> samples, int k) {
        List<Centroid> centroids = new ArrayList<>();
        Random random = new Random();
        // 从样本中随机选出 k 个样本作为初始中心
        Set<Integer> indices = new HashSet<>();
        while (indices.size() < k) {
            int index = random.nextInt(samples.size());
            indices.add(index);
        }
        for (Integer index : indices) {
            Sample s = samples.get(index);
            centroids.add(new Centroid(s.sepalLength, s.sepalWidth, s.petalLength, s.petalWidth));
        }
        return centroids;
    }

    public static void kMeans(List<Sample> samples, int k, int maxIterations) {
        List<Centroid> centroids = initializeCentroids(samples, k);
        boolean changed = true;
        int iteration = 0;

        while (changed && iteration < maxIterations) {
            changed = false;
            iteration++;

            // (2) 将每个样本分配到最近的聚类中心
            for (Sample sample : samples) {
                double minDist = Double.MAX_VALUE;
                int cluster = -1;
                double[] features = sample.getFeatures();
                for (int i = 0; i < centroids.size(); i++) {
                    double dist = euclideanDistance(features, centroids.get(i).getCoordinates());
                    if (dist < minDist) {
                        minDist = dist;
                        cluster = i;
                    }
                }
                // 如果当前聚类标签与之前不同，则标记发生变化
                if (sample.clusterLabel != cluster) {
                    changed = true;
                    sample.clusterLabel = cluster;
                }
            }

            // (3) 根据分配结果更新聚类中心：计算各类样本属性的平均值
            // 先建立 k 个聚类的累加器和计数器
            double[][] sums = new double[k][4];
            int[] counts = new int[k];

            for (Sample sample : samples) {
                int cluster = sample.clusterLabel;
                double[] features = sample.getFeatures();
                for (int j = 0; j < features.length; j++) {
                    sums[cluster][j] += features[j];
                }
                counts[cluster]++;
            }
            // 更新每个聚类中心
            for (int i = 0; i < k; i++) {
                if (counts[i] == 0) continue; // 防止分母为 0
                double newSepalLength = sums[i][0] / counts[i];
                double newSepalWidth  = sums[i][1] / counts[i];
                double newPetalLength = sums[i][2] / counts[i];
                double newPetalWidth  = sums[i][3] / counts[i];

                centroids.set(i, new Centroid(newSepalLength, newSepalWidth, newPetalLength, newPetalWidth));
            }
            System.out.println("迭代 " + iteration + " 次，聚类中心：" + centroids);
        }
        System.out.println("共进行了 " + iteration + " 次迭代。");
    }

    // 将聚类结果写入到文件 cluster.txt
    public static void writeClustersToFile(List<Sample> samples, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Sample sample : samples) {
                bw.write(sample.toString());
                bw.newLine();
            }
            System.out.println("聚类结果已经写入到 " + filename);
        } catch (IOException e) {
            System.err.println("写文件出错：" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // 设置聚类数目 k 和最大迭代次数
        int k = 3;  // 可根据需要自行调整
        int maxIterations = 100;

        // 提供 iris 数据集文件的路径
        String inputFileName = "iris.data";
        List<Sample> samples = readIrisSamples(inputFileName);

        if (samples.isEmpty()) {
            System.err.println("没有读取到样本数据，请检查文件 " + inputFileName);
            return;
        }

        // 使用 K-means 算法聚类数据
        kMeans(samples, k, maxIterations);

        // 将聚类结果写入文件 cluster.txt, 格式为:
        // sepal length,sepal width,petal length,petal width,cluster label
        String outputFileName = "cluster.txt";
        writeClustersToFile(samples, outputFileName);
    }
}
