public class User {
    private List<Service> services;
    public float getTotal() {
        float total = 0.0;
        foreach (Service s in services) {
            MultimediaContent mc = s.getMultimediaContent();
            if(typeof(s)==StreamingService) {
                total += mc.getStreamingPrice();
            }else if(typeof(s)==DownloadService){
                total += mc.getDownloadPrice();
            }
            if (typeof(mc)==PremiumContent) {
                total += mc.getAdditionalFee();
            }
        }
        return total;
    }

    /**
     * Ejercicio 1
     * Revisando el diagrama UML y el código del método getTotal() nos preocupa que su
     * diseño sea un poco frágil y esté violando algunos principios de diseño. Nos planteamos
     * las siguientes preguntas:
     * ¿Este diseño satisface los siguientes principios de diseño? Justifica tu respuesta.
     * a) Ley de Demeter
     * b) Abierto-Cerrado
     * c) Sustitución de Liskov
     * d) Responsabilidad Única
     */

    /**
     * Ejercicio 2
     * Propón una solución a los errores que has encontrado en el primer ejercicio. Realiza
     * los cambios que consideres oportuno tanto en el UML como en el código. Puedes
     * generar código de otras clases si lo ves necesario.
     */
}
