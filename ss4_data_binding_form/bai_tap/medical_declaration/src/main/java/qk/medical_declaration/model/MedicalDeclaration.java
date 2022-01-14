package qk.medical_declaration.model;

public class MedicalDeclaration {
    protected String fullName;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
