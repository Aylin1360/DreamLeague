package com.example.dreamleague;

public class Heap {
    Team items[];
    int lastIndex;

    //2*parentIndex == leftIndex
    //2*parentIndex + 1 == rightIndex
    //leftIndex || rightIndex / 2 == parentIndex
    //index 0 is not used

    public String getTop(){
        return items[1].toString();
    }

    public Heap(int size) {
        items = new Team[size + 1];
        lastIndex = 0;
    }

    public void push(Team data) {
        int newIndex = ++lastIndex;
        int parentIndex = newIndex / 2;
        while ((parentIndex > 0) && data.getOverall() > items[parentIndex].getOverall()) {
            items[newIndex] = items[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        }
        items[newIndex] = data;
    }

    public boolean isEmpty() {
        return (lastIndex == 0) ? true : false;
    }

    private void reheap(int rootIndex) {
        boolean done = false;
        Team orphan = items[rootIndex];
        int leftChildIndex = 2 * rootIndex;
        while (!done && (leftChildIndex <= lastIndex)) {
            int largerChildIndex = leftChildIndex; // assume larger
            int rightChildIndex = leftChildIndex + 1;
            if ((rightChildIndex <= lastIndex) && items[rightChildIndex].getOverall() > items[leftChildIndex].getOverall())
                largerChildIndex = rightChildIndex;
            if (orphan.getOverall() < items[largerChildIndex].getOverall()) {
                items[rootIndex] = items[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            } else
                done = true;
        }
        items[rootIndex] = orphan;
    }

    @Override
    public String toString() {
        String s = "";
        for (int j = 1; j < lastIndex; j++) {
            s += items[j] + " ";
        }
        return s;
    }

    public String winner() {
        String winner = "";
        winner = getTop();
        return winner;
    }
}
