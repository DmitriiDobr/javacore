package javacore.first.worker;

public class Worker {

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            callback.onDone("Task " + i + " is done");
        }
    }

    public void startError() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError("Error happened!");
            } else {
                errorCallback.onError("Task " + i + " is done");
            }
        }

    }
}
