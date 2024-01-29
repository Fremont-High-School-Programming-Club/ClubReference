package Year20234.Patterns;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;

interface Base {
    public int getDataHead();

    public boolean setData(int num);
}

class MockStructure implements Base {
    private ArrayList<Integer> privateData;

    public MockStructure(int[] myData) {
        this.privateData = new ArrayList<Integer>();
        for (int i = 0; i < myData.length; i++) {
            this.privateData.add(myData[i]);
        }
    }

    @Override
    public int getDataHead() {
        return this.privateData.get(0);
    }

    @Override
    public boolean setData(int num) {
        return this.privateData.add(num);
    }
}

class ActualStructure implements Base {
    private HashSet<Integer> privateData;

    public ActualStructure(int[] myData) {
        this.privateData = new HashSet<Integer>();
        for (int i = 0; i < myData.length; i++) {
            this.privateData.add(myData[i]);
        }
    }

    @Override
    public int getDataHead() {
        int greatest = 0;
        for (int i : this.privateData) {
            if (i > greatest) {
                greatest = i;
            }
        }

        return greatest;
    }

    @Override
    public boolean setData(int num) {
        for (int i : this.privateData) {
            if (i == num) {
                return false;
            }
        }

        return this.privateData.add(num);
    }
}

public class Strategy {
    public static void main(String[] args) {
        Base myStructure = new MockStructure(new int[] { 1, 2, 3, 4, 5 });
        System.out.println(myStructure.getDataHead());
        System.out.println(myStructure.setData(1));
        System.out.println(myStructure.getDataHead());
    }
}
