package top.crushing.boot.basic.controller;

/**
 * @author Crush
 * @date 2021/3/9
 * @dercsiption ArticleControllerTest
 */
public class ArticleControllerTest{
    public static void main(String[] args) {
        String name = "111.11.jpg";
        int index = name.lastIndexOf(".");
        System.out.println(index);
        System.out.println(name.substring(index));
    }
}
