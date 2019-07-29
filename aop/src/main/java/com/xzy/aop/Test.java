package com.xzy.aop;

public class Test {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext
//                = new ClassPathXmlApplicationContext("classpath:spring.xml");
//        IndexService indexService = (IndexService) classPathXmlApplicationContext.getBean("service");
//        indexService.service();


//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Spring.class);
//        IndexDaoImpl dao = (IndexDaoImpl) annotationConfigApplicationContext.getBean("dao1");
//        dao.test();
//        dao.aaa();
//        Syst em.out.println(dao instanceof AAA);


//        List<String> strings = new ArrayList<>(Arrays.asList("1", "2"));
        String[] strings = new String[]{"1","2"};

        for (String string : strings) {
            string+="0";
        }
//        strings.(e->{
//            e=e+1;
//        });
//        for (int i = 0; i < strings.length; i++) {
//            strings[i] +=  "0";
//        }
        System.out.println(strings[0]);

//        Class<?>[] classes = new Class[] {IndexDao.class};
//        byte[] bytes = ProxyGenerator.generateProxyClass("IndexDaoDDD", classes);
//
//        File file = new File("/Users/changkaijie/project/IndexDaoAA.class");
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            fileOutputStream.write(bytes);
//            fileOutputStream.flush();
//            fileOutputStream.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }




    }
}
