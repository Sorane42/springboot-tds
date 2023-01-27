class Item constructor(var nom:String) {

    var evaluation:Int=0

    /*override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        val item = other as Item
        return other.nom==this.nom
    }

    override fun hashCode(): Int {
        return nom.hashCode()
    }
 */
    override fun toString(): String {
        return "Item(nom='$nom', evaluation=$evaluation)"
    }




}