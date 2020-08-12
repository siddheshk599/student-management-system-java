class Student {
    public int rollNumber;
    public String name;
    public int physicsMarks;
    public int chemistryMarks;
    public int mathsMarks;
    
    public Student() {}

    public Student(int rollNumber, String name, int physicsMarks, int chemistryMarks, int mathsMarks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.physicsMarks = physicsMarks;
        this.chemistryMarks = chemistryMarks;
        this.mathsMarks = mathsMarks;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getRollNumber() {
        return this.rollNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPhysicsMarks(int physicsMarks) {
        this.physicsMarks = physicsMarks;
    }

    public int getPhysicsMarks() {
        return this.physicsMarks;
    }

    public void setChemistryMarks(int chemistryMarks) {
        this.chemistryMarks = chemistryMarks;
    }

    public int getChemistryMarks() {
        return this.chemistryMarks;
    }

    public void setMathsMarks(int mathsMarks) {
        this.mathsMarks = mathsMarks;
    }

    public int getMathsMarks() {
        return this.mathsMarks;
    }
}