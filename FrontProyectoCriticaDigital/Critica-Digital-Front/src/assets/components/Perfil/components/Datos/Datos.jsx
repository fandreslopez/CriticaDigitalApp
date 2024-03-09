import './Datos.css'

function Datos({ datos }) {
    return (
        <>
                        <div className='profile'> 
                <div className='userName'>
                    <h5 className='profileSection'>Nombre</h5>
                    <p className='profileAnswer'>{datos.nombre} </p>
                </div>
                <div className='firtsName'> 
                    <h5 className='profileSection'>Primer Apellido</h5>
                    <p className='profileAnswer'>{datos.primerApellido}</p>
                </div>
                <div className='secondName'> 
                    <h5 className='profileSection' >Segundo Apellido</h5>
                    <p className='profileAnswer' >{datos.segundoApellido}</p>
                </div>
                <div className='birthdate'>
                    <h5 className='profileSection' >Fecha de nacimiento</h5>
                    <p className='profileAnswer' >{datos.fechaNacimiento}</p>
                </div>
                <div className='gender'>
                    <h5 className='profileSection' >Género</h5>
                    <p className='profileAnswer' >{datos.genero}</p>
                </div>
                <div className='email'>
                    <h5 className='profileSection' >Correo electrónico</h5>
                    <p className='profileAnswer' >{datos.email}</p>
                </div>
                <div className='region'>
                    <h5 className='profileSection'>Región</h5>
                    <p className='profileAnswer' >{datos.region}</p>
                </div>
                <div className='comuna'>
                    <h5 className='profileSection' >Comuna</h5>
                    <p className='profileAnswer' >{datos.comuna}</p>
                </div>
                <div className='distrito'>
                    <h5 className='profileSection' >Distrito</h5>
                    <p className='profileAnswer' >{datos.distrito}</p>
                </div>
            </div>
        </>
    );
};

export default Datos;