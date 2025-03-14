public class Value {
    private char x;
    private double y;
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {//是否为同一个对象
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {//是否为同一类型
            return false;
        }

        Value other = (Value) obj;
        return this.x == other.x && Double.compare(this.y, other.y) == 0;//分别相等
    }

    public Value(char x, double y){
        this.x = x;
        this.y = y;
    }
    public static void main(String[] args) {
        //...
    }
}
