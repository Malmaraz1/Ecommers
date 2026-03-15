import axios from "axios";
import urlBackend from "./urlBackend";
const BACKEND_URL = urlBackend();


export const getProductos = async (email, password) => {
  const url = `${BACKEND_URL}/usuario/login`;

  try {
    const response = await axios.post(url, {
      email,
      password,
    });

    return response.data;
  } catch (err) {
    if (err.response) {
      console.error("Error completo:", err);
      const errorMessage =
        err.response.data?.message || "Credenciales incorrectas";
      throw new Error(errorMessage);
    } else {
      throw new Error("Error de conexión al servidor");
    }
  }
};