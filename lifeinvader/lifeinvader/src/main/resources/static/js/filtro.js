function onLoad() {
	var app = new Vue(
		{
			el : '#vagas',
			data : {
				vagas : []
			},
			mounted(){
				axios
					.get('http://localhost:8080/api/pesquisa')
					.then(response => (this.vagas = response.data))
			}
		});

}
