package edu.spring.td1.models

class Item {
    var nom: String? = null
    var evaluation = 0

    fun getNom(): String? {
        return this.nom
    }

    fun getEvaluation(): Int {
        return this.evaluation
    }

    fun setNom(Nnom:String){
        this.nom = Nnom
    }

    fun setEvaluation(eval : Int){
        this.evaluation = eval
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val item = o as Item
        return if (evaluation != item.evaluation) false else nom == item.nom
    }
}