package bonniefx.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Recipient extends Person {
    private boolean isDeceased;
    private PlotCode plotCode;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;

    public Recipient() {
    }

    public Recipient(String name, boolean isDeceased, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        super(name);
        this.isDeceased = isDeceased;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Utils.appendString(builder, "bonniefx.model.Recipient: " + getName());
        Utils.appendString(builder, "Date of Birth: " + dateOfBirth.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        Utils.appendString(builder, "Is Deceased: " + isDeceased);
        if (isDeceased) {
            Utils.appendString(builder, "Date of Death: " + dateOfDeath.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        }
        Utils.appendString(builder, "Age: " + getAge());
        return builder.toString();
    }

    public boolean diedOverOneYearAgo() {
        return Period.between(dateOfDeath, LocalDate.now()).getYears() > 1;
    }

    public boolean isDeceased() {
        return isDeceased;
    }

    public int getAge() {
        if (isDeceased && dateOfDeath != null) {
            return Period.between(dateOfBirth, dateOfDeath).getYears();
        } else
            return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public PlotCode getPlotCode() {
        return plotCode;
    }

    public void setPlotCode(PlotCode plotCode) {
        this.plotCode = plotCode;
    }

    public void setDeceased(boolean deceased) {
        isDeceased = deceased;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }


}
