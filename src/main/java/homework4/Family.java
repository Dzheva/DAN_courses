package homework4;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    static {
        System.out.println("Class Family is loading...");
    }

    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Family(Human mother, Human father, Pet pet) {
        if (mother != null && father != null) {
            this.mother = mother;
            this.father = father;
            this.mother.setFamily(this);
            this.father.setFamily(this);
            this.children = new Human[0];
            this.pet = pet;
        } else {
            throw new IllegalArgumentException("Both mother and father must be provided.");
        }
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void addChild(Human child) {
        if (child == null) {
            System.out.println("Child cannot be null.");
        } else {
            int oldLength = children.length;
            children = Arrays.copyOf(children, oldLength + 1);
            children[oldLength] = child;
            child.setFamily(this);
        }
    }

    public void deleteChildByIndex(int index) {
        if (children == null || index < 0 || index >= children.length) {
            System.out.println("Invalid index or no children to delete.");
        } else {
            Human childToRemove = children[index];
            childToRemove.setFamily(null);

            int newSize = children.length - 1;
            Human[] newChildren = new Human[newSize];
            System.arraycopy(children, 0, newChildren, 0, index);
            System.arraycopy(children, index + 1, newChildren, index, newSize - index);
            children = newChildren;
        }
    }

    public void deleteChild(Human child) {
        if (child == null) {
            System.out.println("The child is null");
        } else {
            int index = -1;
            for (int i = 0; i < children.length; i++) {
                if (Objects.equals(child.getName(), children[i].getName())) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                deleteChildByIndex(index);
            } else {
                System.out.println("This child is not from this family.");
            }
        }
    }

    public int countFamily() {
        if (children.length == 0) return 2;
        return children.length + 2;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother.toString() +
                ", father=" + father.toString() +
                ", children=" + Arrays.toString(children) +
                ", pet=" + pet.toString() +
                '}';
    }
}
