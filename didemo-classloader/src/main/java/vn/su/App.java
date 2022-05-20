package vn.su;

import java.lang.reflect.Method;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        demoComponentScan();
        inspectFooBar();
    }

    private static void inspectFooBar() {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        try{
            Object obj = customClassLoader.findClass("foo.Bar").getDeclaredConstructor().newInstance();
            Class<?> objClass = obj.getClass();
            Method[] methods = objClass.getDeclaredMethods();
            Class<?>[] interfaces = objClass.getInterfaces();
            System.out.printf(String.format("Methods of %s class"), obj.getClass().getName());
            for(Method method : methods){
                System.out.println(method.getName());
                method.invoke(obj, null);
            }
            for(Class<?> i : interfaces){
                System.out.println(i.getName());
                
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void demoComponentScan() {
        ClasspathInspector.componentScan().forEach(e->System.out.println(e.getName()));
    }
}
