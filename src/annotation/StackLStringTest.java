package annotation;

/**
 * Created by caoxiaohong on 17/3/19.
 */
public class StackLStringTest extends StackL<String> {
    @Test void _push(){
        push("one");
        assert top().equals("one");
        push("two");
        assert top().equals("two");
    }

}
