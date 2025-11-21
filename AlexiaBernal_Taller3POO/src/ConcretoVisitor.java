/*
 * Alexia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
 */
public class ConcretoVisitor implements TareaVisitor 
{

	@Override
	public void visitarBug(Bug b) {
		System.out.println("Visitante: Bug afecta criticidad del proyecto. ID: " + b.getId());
		
	}

	@Override
	public void visitarCaracteristica(Caracteristica c) {
		System.out.println("Visitante: Característica impacta estimación de tiempo. ID: " + c.getId());
		
	}

	@Override
	public void visitarDocumentacion(Documentacion d) {
		System.out.println("Visitante: Documentación mejora calidad. ID: " + d.getId());
		
	}
	
}
