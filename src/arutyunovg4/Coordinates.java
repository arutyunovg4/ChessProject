package arutyunovg4;


import arutyunovg4.pieces.CoordinatesShift;

public record Coordinates(File file, Integer rank) {


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (file != that.file) return false;
        return rank.equals(that.rank);
    }

    @Override
    public String toString() {
        return file + String.valueOf(rank);
    }

    public Coordinates shift(CoordinatesShift shift) {
        return new Coordinates(File.values()[this.file.ordinal() + shift.fileShift], this.rank + shift.rankShift);
    }

    public boolean canShift(CoordinatesShift shift) {
        int f = file().ordinal() + shift.fileShift;
        int r = rank + shift.rankShift;

        if ((f < 0) || (f > 7)) return false; // 0..7 - good
        if ((r < 1) || (r > 8)) return false; // 1..8 - good

        return true;
    }
}
