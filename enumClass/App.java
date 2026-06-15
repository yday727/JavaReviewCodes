package enumClass;

public class App {
    public static void main(String[] args) {
        System.out.println("状态码：" + HttpStatus.SUCCESS.getCode());
        System.out.println("描述：" + HttpStatus.SUCCESS.getMsg());
    }
}
