//package annotation;
//
//import com.sun.mirror.apt.AnnotationProcessor;
//import com.sun.mirror.apt.AnnotationProcessorEnvironment;
//import com.sun.mirror.apt.AnnotationProcessorFactory;
//import com.sun.mirror.declaration.AnnotationTypeDeclaration;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Set;
//
///**
// * Created by caoxiaohong on 17/3/19.
// */
//
////处理器工厂 @4
//public class InterfaceExtractorProcessorFactory
//   implements AnnotationProcessorFactory{
//    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds, AnnotationProcessorEnvironment env){
//        return new InterfaceExtractorProcessor(env);
//    }
//    public Collection<String> supportedAnnotationTypes(){
//        return Collections.singleton("annotations.ExtractInterface");
//    }
//    public Collection<String> supportedOptions(){
//        return Collections.emptySet();
//    }
//}
