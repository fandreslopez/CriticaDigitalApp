import { useForm } from "react-hook-form";

import "./EditarPerfil.css";

const EditarPerfil = ({ usuarioActual, actualizarDatos, cambiarVista }) => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  const onSubmit = (data) => {
    console.log(data);
    const nuevosDatos = { ...usuarioActual, ...data };
    actualizarDatos(nuevosDatos);
    cambiarVista("datos");
  };

  return (
    <>
      <form className="formulario" onSubmit={handleSubmit(onSubmit)}>
        <label className="field">
          <h4>Nombre</h4>
          <input
            className="ingresoDatos"
            {...register("nombre", { required: true })}
          />
        </label>
        <label className="field">
          <h4>Primer Apellido</h4>
          <input
            className="ingresoDatos"
            {...register("primerApellido", { required: true })}
          />
        </label>
        <label className="field">
          <h4>Segundo Apellido</h4>
          <input
            className="ingresoDatos"
            {...register("segundoApellido", { required: true })}
          />
        </label>
        <label className="field">
          <h4>Fecha de Nacimiento</h4>
          <input
            className="ingresoDatos"
            {...register("fechaNacimiento", { required: true })}
          />
        </label>
        <label className="field">
          <h4>Género</h4>
          <input
            className="ingresoDatos"
            {...register("genero", { required: true })}
          />
        </label>
        <label className="field">
          <h4>Correo Electrónico</h4>
          <input
            className="ingresoDatos"
            {...register("email", { required: true })}
          />
        </label>
        <label className="field">
          <h4>Región</h4>
          <input
            className="ingresoDatos"
            {...register("region", { required: true })}
          />
        </label>
        <label className="field">
          <h4>Comuna</h4>
          <input
            className="ingresoDatos"
            {...register("comuna", { required: true })}
          />
        </label>
        <label className="field">
          <h4>Distrito</h4>
          <input
            className="ingresoDatos"
            {...register("distrito", { required: true })}
          />
        </label>
        <div className="boton">
          <button className="update" type="submit">
            Actualizar Datos
          </button>
        </div>
      </form>
    </>
  );
};

export default EditarPerfil;
