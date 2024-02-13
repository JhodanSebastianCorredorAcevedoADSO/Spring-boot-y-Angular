import { TipoDocumento } from "./tipo-documento";

// clase de tipo de dato de las propiedades de las personas
export class Persona {

    idPersona: number;
    numeroDocumento: string;
    tipoDocumento: TipoDocumento;
    nombre: string;
    apellido: string;
    activo: boolean;
}
