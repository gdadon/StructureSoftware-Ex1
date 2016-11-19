package ex1.resources;

public class Edge {
 
    protected Vertex target;
    protected double weight;
    
    
    /**
     * Edge constructor
     * @param argTarget - target vertex
     * @param argWeight - weight to target vertex
     */
    public Edge(Vertex argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
    }
    
    public Vertex getTarget() {
		return target;
	}

	public void setTarget(Vertex target) {
		this.target = target;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
    public String toString() {
        return "Edge{" + "target=" + target + ", weight=" + weight + '}';
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!(target.id == other.target.id))
			return false;
		return true;
	}
	
}