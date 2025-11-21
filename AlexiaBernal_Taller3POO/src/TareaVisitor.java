/*
 * Alexia Bernal Mardones
 * 21.505.877-8
 * Ingeniería Civil en Computación e Informática
 */
public interface TareaVisitor 
{
	void visitarBug(Bug b);
	void visitarCaracteristica(Caracteristica c);
	void visitarDocumentacion(Documentacion d);
}
