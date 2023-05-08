package es.joseluisgs.dam;

public class CarroCompra {

    static final float IVA = 21.0f;
    static final float DESCUENTO = 10.f;

    public static void main(String[] args) {
        System.out.println("Carro Compra Ejemplo");

        // Faltaría una UI que introdujese los valores

        int[] cantidades = new int[]{1, 2, 1};
        float[] precios = new float[]{10.00f, 25.50f, 32.30f};

        boolean isValid = isLogintudNoCero(cantidades, precios) &&
                isPreciosValidos(precios) &&
                isCantidadesValidas(cantidades) &&
                isDescuentoValido(DESCUENTO) &&
                isImpuestoValido(IVA);

        if (isValid) {
            float subTotal = getSubTotal(cantidades, precios);
            float descuentoAplicado = getDescuentoAplicado(subTotal, DESCUENTO);
            float precioConDescuento = subTotal - descuentoAplicado;
            float ivaAplicado = getIvaAplicado(subTotal, descuentoAplicado, IVA);
            float total = getPrecioTotal(precioConDescuento, ivaAplicado);

            printCarroCompra(cantidades, precios);
            System.out.println("Subtotal: " + subTotal);
            System.out.println("Descuento: " + descuentoAplicado);
            System.out.println("IVA: " + ivaAplicado);
            System.out.println("Total: " + total);

        } else {
            // TODO: meter 3 if para dar el mensaje claro al usuario
            System.err.println("Error en carro de compra. Los datos no son correctos");
        }

    }

    private static void printCarroCompra(int[] cantidades, float[] precios) {
        for (int i = 0; i < cantidades.length; i++) {
            System.out.println("Cantidad: " + cantidades[i] + " Precio: " + precios[i]);
        }
    }

    public static boolean isLogintudNoCero(int[] cantidades, float[] precios) {
        return cantidades.length == precios.length && cantidades.length > 0;
    }

    public static boolean isPreciosValidos(float[] precios) {
        for (float precio : precios) {
            if (precio <= 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCantidadesValidas(int[] cantidades) {
        for (int cantidad : cantidades) {
            if (cantidad <= 0) {
                return false;
            }
        }
        return true;
    }

    public static float getSubTotal(int[] cantidades, float[] precios) {
        float subTotal = 0;
        for (int i = 0; i < cantidades.length; i++) {
            subTotal += cantidades[i] * precios[i];
        }
        return redondeo(subTotal);
    }

    public static boolean isDescuentoValido(float descuento) {
        return descuento >= 0;
    }

    public static boolean isImpuestoValido(float impuesto) {
        return impuesto > 0;
    }

    public static float getDescuentoAplicado(float subTotal, float descuento) {
        return redondeo(subTotal * (descuento / 100));
    }

    public static float getIvaAplicado(float subTotal, float descuento, float iva) {
        return redondeo((subTotal - descuento) * (iva / 100));
    }

    public static float getPrecioTotal(float precioConDescuento, float myIVA) {
        return redondeo(precioConDescuento + myIVA);
    }

    public static float redondeo(float cantidad) {
        return (float) (Math.round(cantidad * 100.0) / 100.0);
    }
}
