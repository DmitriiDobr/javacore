package javacore.first.worker;

@FunctionalInterface
public interface OnTaskDoneListener {
    void onDone(String result);
}
