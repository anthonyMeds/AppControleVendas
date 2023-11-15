package br.com.dermocosmeticos.appDermocosmeticos.Configuration.result;


public class EntidadeResult {
    private ResultTransactional result = new ResultTransactional();

    public ResultTransactional getResult() {
        return this.result;
    }

    public void setResult(final ResultTransactional result) {
        this.result = result;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof EntidadeResult)) {
            return false;
        } else {
            EntidadeResult other = (EntidadeResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$result = this.getResult();
                Object other$result = other.getResult();
                if (this$result == null) {
                    if (other$result != null) {
                        return false;
                    }
                } else if (!this$result.equals(other$result)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EntidadeResult;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $result = this.getResult();
        result = result * 59 + ($result == null ? 43 : $result.hashCode());
        return result;
    }

    public String toString() {
        return "EntidadeResult(result=" + this.getResult() + ")";
    }

    public EntidadeResult() {
    }

    public EntidadeResult(final ResultTransactional result) {
        this.result = result;
    }
}
