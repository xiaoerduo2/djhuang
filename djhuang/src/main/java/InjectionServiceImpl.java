public class InjectionServiceImpl implements  InjectionService {

    public  InjectionDao injectionDao;

   /* public  void setInjectionDao(InjectionDao injectionDao){
        this.injectionDao = injectionDao;
    }*/
    public InjectionServiceImpl(InjectionDao injectionDao){
        this.injectionDao = injectionDao;
    }

    public void save(String args) {
        //模拟业务处理
        System.out.println("接受到的参数是："+args);
        args = args+this.hashCode();
        injectionDao.save(args);
    }
}
