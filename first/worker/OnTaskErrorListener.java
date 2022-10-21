package javacore.first.worker;


@FunctionalInterface
public interface OnTaskErrorListener {
    void onError(String result);
}
