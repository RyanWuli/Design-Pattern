package com.zxw.builder.application;

/**
 * @Author: Ryan
 * @Date: 2021/5/12 17:16
 * @Version: 1.0
 * @Description:
 */
public class PersonTest {

    public static void main(String[] args) {
        Person person = new Person.PersonBuilder().basicInfoBuild(123, "张三", 15)
                .weightBuild(54.5)
                .scoreBuild(95)   // 可以自定义组装参数，不用的不构建就完了，不用传 null 这些很方便，灵活组装需要的参数就行了
                .locationBuild("南城大道", "3502")
                .build();

        System.out.println(person);
    }
}


