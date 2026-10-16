package gautrin.fernando.directorio.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import gautrin.fernando.directorio.modelos.Usuario
import gautrin.fernando.directorio.modelos.UsuarioRepositorio

class UsuarioViewModel(
    private val repositorio: UsuarioRepositorio
) : ViewModel() {
    private val _usuarios = mutableStateOf<List<Usuario>>(emptyList())
    val usuarios: State<List<Usuario>> = _usuarios
    val miUsuario: Usuario = repositorio.getMiUsuario()
    init {
        cargarUsuarios()
    }
    private fun cargarUsuarios() {
        _usuarios.value = repositorio.getUsuarios()
    }
}