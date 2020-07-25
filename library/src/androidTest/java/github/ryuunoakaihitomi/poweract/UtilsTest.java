package github.ryuunoakaihitomi.poweract;

import android.content.Context;
import android.util.SparseArray;
import android.widget.Toast;

import androidx.test.annotation.UiThreadTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UtilsTest {

    @Test
    public void getClassIntApiConstant() throws NoSuchFieldException, IllegalAccessException {
        final Class<?> testClazz = Toast.class;
        final String prefix = "LENGTH";
        final SparseArray<String> constants = Utils.getClassIntApiConstant(testClazz, prefix);
        for (int i = 0; i < constants.size(); i++) {
            final String value = constants.valueAt(i);
            assertTrue(value.startsWith(prefix));
            assertEquals(testClazz.getDeclaredField(value).getInt(null), constants.keyAt(i));
        }
    }

    @Test
    public void getClassIntApiConstantString() {
        assertEquals("MODE_PRIVATE", Utils.getClassIntApiConstantString(Context.class, "MODE", 0));
    }

    /**
     * @see <a href="https://developer.android.com/training/testing/fundamentals#on-device-unit-tests">Instrumented unit tests</a>
     */
    @UiThreadTest
    @Test
    public void isMainThread() {
        assertTrue(Utils.isMainThread());
        new Thread(() -> assertFalse(Utils.isMainThread())).start();
    }
}