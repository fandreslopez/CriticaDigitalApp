import React from "react";
import "./Inicio.css";
import { useState, useEffect } from "react";
import Modal from "../components/Modales/ModalCuenta";
import ModalLogin from "../components/Modales/ModalLogin";

export default function Inicio({ setUser }) {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const [isModalAbierto, setIsModalAbierto] = useState(false);
  function openModal() {
    setIsModalOpen(true);
  }

  function closeModal() {
    setIsModalOpen(false);
  }

  function ModalAbierto() {
    setIsModalAbierto(true);
  }

  function ModalCerrar() {
    setIsModalAbierto(false);
  }

  return (
    <div className="esquema">
      <h1 id="lema">DONDE TU OPINIÓN RESUENA, DONDE TU IMPACTO CUENTA.</h1>
      <aside>
        <div className="registro">
          <p>ACTÚA AHORA</p>
          <button className="boton" onClick={openModal}>
            CREAR CUENTA
          </button>
          <Modal isOpen={isModalOpen} onClose={closeModal} />
          <p>¿YA TIENES UNA CUENTA?</p>
          <button className="btn-inicio" onClick={ModalAbierto}>
            INICIAR SESIÓN
          </button>
          <ModalLogin
            isAbierto={isModalAbierto}
            onCerrado={ModalCerrar}
            setUser={setUser}
            setIsModalAbierto={setIsModalAbierto}
          />
        </div>
      </aside>
    </div>
  );
}
