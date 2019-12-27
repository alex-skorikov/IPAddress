package ru.skorikov;

import java.util.Objects;

/**
 * Class Dolly 2.
 */
public class Dolly2 {
    /**
     * Field char.
     */
    private static char staticChar = 'D';
    /**
     * Field final String.
     */
    private static final String FINAL_STRING = "Dolly";
    /**
     * Field string.
     */
    private String str;
    /**
     * Field num.
     */
    private Integer num;
    /**
     * Field 'name' from inner class.
     */
    private String innerClassName;

    /**
     * Constructor.
     */
    Dolly2() {
        this.str = "Dolly";
        this.num = 125;
        innerClassName = new InnerDolly2().getName();
    }

    /**
     * Inner class.
     */
    class InnerDolly2 {
        /**
         * Class 'Name'.
         */
        private String name;

        /**
         * Constructor.
         */
        InnerDolly2() {
            this.name = "Inner Dolly2 class";
        }

        /**
         * Get name.
         * @return name.
         */
        public String getName() {
            return name;
        }

        /**
         * Set name.
         * @param name name.
         */
        public void setName(String name) {
            this.name = name;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dolly2 dolly2 = (Dolly2) o;
        return Objects.equals(str, dolly2.str)
                && Objects.equals(num, dolly2.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str, num);
    }
}
