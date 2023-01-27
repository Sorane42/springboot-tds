class Item constructor(var nom:String) {

    var evaluation:Int=0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Item

        if (nom != other.nom) return false
        if (evaluation != other.evaluation) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nom.hashCode()
        result = 31 * result + evaluation
        return result
    }

    override fun toString(): String {
        return "Item(nom='$nom', evaluation=$evaluation)"
    }


}