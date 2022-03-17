let app = new Vue({
    el: '#app',
    data: {
        ingreso: {
            usuario: "",
            contraseña: ""
        },
        registro: {
            nombre: "",
            apellido: "",
            telefono: "",
            email: "",
            contraseña: "",
            fecha: "",
            ciudad: "",
            nivel: "",
            rol: "",
        },
        modalIngreso: false,
        modalRegistro: false,
    },
    mounted() {
        pagina = document.querySelector(".contenedor-total");
    },
    methods: {
        abrirModal() {
            if (this.modalIngreso == false) {
                this.modalIngreso = true;
                pagina.classList.add('desenfocar');
            } else {
                this.modalIngreso = false;
                pagina.classList.remove('desenfocar');
            }
        },
        cerrarModal() {
            this.modalIngreso = false;
        },
        ingresar() {
            axios.post('/api/login', `email=${this.ingreso.usuario}&password=${this.ingreso.contraseña}`, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                .then(response => {
                    console.log('ingreso');
                })
                .catch(response => {
                    console.log(response.data);
                })
        },
        abrirRegistro() {
            if (this.modalRegistro == false) {
                pagina.classList.add('desenfocar');
                this.modalRegistro = true;
                this.modalIngreso = false;

            } else {
                pagina.classList.remove('desenfocar');
                this.modalRegistro = false;
                this.modalIngreso = true;

            }
        },
        registrarme() {
            axios.post('/api/..', `nombre=${this.registro.nombre}&apellido=${this.registro.apellido}&telefono=${this.registro.telefono}&email=${this.registro.email}&password=${this.registro.contraseña}&fechaNacimiento=${this.registro.fecha}&ciudad=${this.registro.ciudad}&nivel=${this.registro.nivel}&rol=${this.registro.rol}`, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                .then(response => {

                })
                .catch(response => {
                    console.log(response.data);
                })
        }
    },
})