package autowire;

public class BeanAutowireService {
    private BeanAutowireDao beanAutowireDao;

    /*public void setBeanAutowireDao(BeanAutowireDao beanAutowireDao) {
        this.beanAutowireDao = beanAutowireDao;
    }*/
    public BeanAutowireService(BeanAutowireDao beanAutowireDao){
        this.beanAutowireDao = beanAutowireDao;
    }

    public void say(String word){
        beanAutowireDao.say(word);
    }
}
