package ChessLLD;

import java.util.Objects;

public class Position {
    private int rowNo;
    private int colNo;

    public Position(int rowNo, int colNo) {
        this.rowNo = rowNo;
        this.colNo = colNo;
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public int getColNo() {
        return colNo;
    }

    public void setColNo(int colNo) {
        this.colNo = colNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return rowNo == position.rowNo && colNo == position.colNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowNo, colNo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Position{");
        sb.append("rowNo=").append(rowNo);
        sb.append(", colNo=").append(colNo);
        sb.append('}');
        return sb.toString();
    }
}
