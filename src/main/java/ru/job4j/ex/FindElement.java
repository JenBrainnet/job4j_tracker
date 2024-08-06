package ru.job4j.ex;

public class FindElement {

    public static int indexOf(String[] values, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < values.length; i++) {
            if (key.equals(values[i])) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return result;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (ElementAbuseException ea) {
            ea.printStackTrace();
        } catch (ElementNotFoundException en) {
            en.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] values = {"Amazon", "Ebay"};
        try {
            indexOf(values, "Ozon");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

}
