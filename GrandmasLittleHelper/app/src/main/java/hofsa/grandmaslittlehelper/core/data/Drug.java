package hofsa.grandmaslittlehelper.core.data;

/**
 * Created by Sam on 12.01.15.
 */
public class Drug {
    private long mDrugId;
    private String mName;
    private String mAffliction;
    private String mSideAction;
    private Integer mQuantity;
    private String mUnit;
    private String mVisualMark;

    public long getDrugId() {
        return mDrugId;
    }

    public void setDrugId(long mId) {
        this.mDrugId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getAffliction() {
        return mAffliction;
    }

    public void setAffliction(String mAffliction) {
        this.mAffliction = mAffliction;
    }

    public String getSideAction() {
        return mSideAction;
    }

    public void setSideAction(String mSideAction) {
        this.mSideAction = mSideAction;
    }

    public Integer getQuantity() {
        return mQuantity;
    }

    public void setQuantity(Integer mQuantity) {
        this.mQuantity = mQuantity;
    }

    public String getVisualMark() {
        return mVisualMark;
    }

    public void setVisualMark(String mVisualMark) {
        this.mVisualMark = mVisualMark;
    }

    public String getUnit(){ return mUnit; }

    public void setUnit(String mUnit){ this.mUnit = mUnit;}

}
