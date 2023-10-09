import { Component } from '@angular/core';

@Component({
  selector: 'app-section-four',
  templateUrl: './section-four.component.html',
  styleUrls: ['./section-four.component.scss']
})
export class SectionFourComponent {
    Contador: number = 0;

  isChecked = false;

  toggleCheck() {
    this.isChecked = !this.isChecked;
  }


  mantenimientos = [
    { orden: "One", nombre: "Cambio aceite del motor", descripcion: "Cambiar el aceite del filtro de no se donde" },
    { orden: "Two", nombre: "Cambio filtro de aceite", descripcion: "Cambiar el aceite del aceite de no se donde" },
    { orden: "Three", nombre: "Cambio filtro de combustible", descripcion: "Alinear las ruedas del vehículo" },
    { orden: "Four", nombre: "Cambio aceite hidráulico", descripcion: "Rotar los neumáticos para un desgaste uniforme" },
    { orden: "Five", nombre: "Cambio aceite del diferencial", descripcion: "Reemplazar las pastillas y discos de freno" },
    { orden: "Six", nombre: "Lubricación del eje delantero", descripcion: "Reemplazar las bujías del motor" },
    { orden: "Seven", nombre: "Cambio aceite del engranaje planetario", descripcion: "Verificar la salud de la batería" },
    { orden: "Eight", nombre: "Lubricación del balancín", descripcion: "Reemplazar el filtro de aire del motor" },
    { orden: "Nine", nombre: "Lubricación de charnelas", descripcion: "Lavar y encerar el vehículo para mantenerlo limpio y brillante" },
    { orden: "Ten", nombre: "Lubricación de crucetas", descripcion: "Reemplazar el líquido de frenos para mantener un buen rendimiento de frenado" }
  ];

   mostrarInformacion(index: number) {
   
    if (this.indicesActivados.includes(index)) {
           this.indicesActivados = this.indicesActivados.filter(i => i !== index);
    } else {
      
      this.indicesActivados.push(index);
    }
   }




   indicesActivados: number[] = [];
  
   // Método que se llama cuando se cambia el estado del checkbox
   toggleCheckbox(index: number) {
       console.log("Prueba de checkbox "+index)

       

   }
 




}

