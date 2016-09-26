package decompiler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


public class ClassAnalyzer {

    Class clazz;
    Object obj;

    public ClassAnalyzer(Object obj) {
        this.clazz = obj.getClass();
        this.obj = obj;

    }

    public void callBlackLabelAnotatedMethods() {

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BlackLabel.class)) {
                try {
                    System.out.println(
                            "Invoke : " + methodReturnType(method) + method.getName() + methodParametersTypes(method))
                    ;
                    Object[] arguments;
                    if (method.getParameterCount() == 0) arguments = null;
                        //dummy for doNothing(int,float,String)  method
                    else arguments = new Object[]{1, 2.2f, "srk"};
                    System.out.println("Result : " + (String) method.invoke(obj, arguments));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void printAnnotatedMethodsAndParams(){
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if(method.getAnnotations().length > 0) {
                System.out.println(method.getName() + methodParametersTypes(method) + " has annotattion:");
                for (Annotation anot : method.getAnnotations()){
                    System.out.println(anot.toString());
                };
                System.out.println();
            }

        }

    }
    public String getSuperClassName(){
       return  "SupperClass name : " + clazz.getSuperclass().toString();
    }

    private String methodReturnType(Method method) {
        String[] res = method.getReturnType().toString().split("\\.");
        return res[res.length - 1] + " ";
    }

    private String methodParametersTypes(Method method) {
        StringBuilder res = new StringBuilder("(");
        if (method.getParameters().length > 0) {
            for (Parameter type : method.getParameters()) {
                String[] tmp = type.toString().toString().split("\\.");
                res.append(tmp[tmp.length - 1]).append(',');
            }
            ;
            res.setLength(res.length() - 1);
        }
        res.append(')');
        return res.toString();
    }
}
