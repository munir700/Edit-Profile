package assignment.cleancode.editprofile.models;

import com.google.gson.annotations.SerializedName;

public class SingleChoiceAttributes
{
    private Figure[] figure;

    @SerializedName("marital_status")
    private MaritalStatus[] maritalStatus;

    private Gender[] gender;

    private Ethnicity[] ethnicity;

    private Religion[] religion;

    public Figure[] getFigure ()
    {
        return figure;
    }

    public void setFigure (Figure[] figure)
    {
        this.figure = figure;
    }

    public MaritalStatus[] getMaritalStatus()
    {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus[] maritalStatus)
    {
        this.maritalStatus = maritalStatus;
    }

    public Gender[] getGender ()
    {
        return gender;
    }

    public void setGender (Gender[] gender)
    {
        this.gender = gender;
    }

    public Ethnicity[] getEthnicity ()
    {
        return ethnicity;
    }

    public void setEthnicity (Ethnicity[] ethnicity)
    {
        this.ethnicity = ethnicity;
    }

    public Religion[] getReligion ()
    {
        return religion;
    }

    public void setReligion (Religion[] religion)
    {
        this.religion = religion;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [figure = "+figure+", maritalStatus = "+ maritalStatus +", gender = "+gender+", ethnicity = "+ethnicity+", religion = "+religion+"]";
    }
}
	