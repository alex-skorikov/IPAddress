package ru.skorikov;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Class CopyUtils for Objec copy.
 */
public class CopyUtils {
    /**
     * Constructor.
     */
    public CopyUtils() {
    }

    /**
     * Get Object fields.
     * @param object object.
     * @return array fields.
     */
    private Field[] getFields(Object object) {
        return object.getClass().getDeclaredFields();
    }

    /**
     * Get object  copy.
     * @param object object.
     * @param <T> object type.
     * @return copy object.
     * @throws ReflectiveOperationException exception.
     */
    <T> T deepCopy(Object object)
            throws ReflectiveOperationException {
        Class clazz = object.getClass();
        Constructor[] constructors = clazz.getDeclaredConstructors();
        Object clone = new Object();
        //Получим Instance класса исходного объекта.
        for (Constructor constructor : constructors) {
            if (constructor.newInstance() != null) {
                clone = constructor.newInstance();
                break;
            }
        }
        //Поля исходного объекта.
        Field[] fields = getFields(object);
        for (Field field : fields) {
            field.setAccessible(true);
            boolean isObject = field.getType().isAssignableFrom(object.getClass());
            //Поля объекта копии.
            for (Field fieldClone : getFields(clone)) {
                fieldClone.setAccessible(true);
                //Если поле - Объект.
                if (isObject) {
                    if (field.getName().equals(fieldClone.getName())) {
                        fieldClone.set(clone, field.get(object));
                        fieldClone.setAccessible(false);
                        break;
                    }
                } else {
                    if (field.getName().equals(fieldClone.getName())
                            && !field.getType().isAssignableFrom(object.getClass())) {
                        if (Modifier.isFinal(field.getModifiers())) {
                            fieldClone.setAccessible(false);
                            continue;
                        } else {
                            fieldClone.set(clone, field.get(object));
                            fieldClone.setAccessible(false);
                            break;
                        }
                    }
                }
            }
            field.setAccessible(false);
        }
        return (T) clone;
    }
}
