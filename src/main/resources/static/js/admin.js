document.addEventListener('DOMContentLoaded', function() {
  // Manejo del menú lateral
  let sidebar = document.querySelector(".sidebar");
  let sidebarBtn = document.querySelector(".sidebarBtn");
  sidebarBtn.onclick = function() {
    sidebar.classList.toggle("active");
    if(sidebar.classList.contains("active")){
      sidebarBtn.classList.replace("bx-menu" ,"bx-menu-alt-right");
    } else {
      sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
    }
  };

  // Variables para las ventanas modales y los botones de cierre
  const modalEdit = document.getElementById('modal_edit');
  const modalDelete = document.getElementById('modal_delete');
  const closeEditButton = document.getElementById('close-edit');
  const closeDeleteButton = document.getElementById('close-delete');
  
  // Funciones para mostrar y cerrar las ventanas modales
  function showModal(modal) {
    modal.classList.add('show');
  }

  function closeModal(modal) {
    modal.classList.remove('show');
  }

  // Manejo del formulario de edición
  const editForm = document.getElementById('edit-form');
  editForm.addEventListener('submit', function(event) {
    event.preventDefault(); // Evitar que se envíe el formulario por defecto
    
    const formData = new FormData(this); // Obtener los datos del formulario
    fetch(this.action, {
      method: 'POST',
      body: formData
    })
    .then(response => {
      if (response.ok) {
        closeModal(modalEdit); // Cerrar la ventana modal si la respuesta es exitosa
        location.reload(); // Recargar la página para actualizar la lista de categorías
      } else {
        console.error('Error al actualizar la categoría');
        // Aquí puedes mostrar un mensaje de error o realizar alguna otra acción
      }
    })
    .catch(error => {
      console.error('Error al actualizar la categoría:', error);
      // Aquí puedes mostrar un mensaje de error o realizar alguna otra acción
    });
  });

  // Manejo del botón de cerrar ventana modal de edición
  closeEditButton.addEventListener('click', function() {
    closeModal(modalEdit);
  });

  // Manejo del botón de cerrar ventana modal de eliminación
  closeDeleteButton.addEventListener('click', function() {
    closeModal(modalDelete);
  });

  // Obtener todos los botones de edición y eliminar
  const editButtons = document.querySelectorAll('.edit-btn');
  const deleteButtons = document.querySelectorAll('.delete-btn');

  // Manejo del clic en botones de edición
  editButtons.forEach(button => {
    button.addEventListener('click', function(event) {
      event.preventDefault();
      const id = this.getAttribute('data-id');
      const nombre = this.getAttribute('data-nombre');
      document.getElementById('edit-id').value = id;
      document.getElementById('edit-nombre').value = nombre;
      showModal(modalEdit);
    });
  });

  // Manejo del clic en botones de eliminación
  deleteButtons.forEach(button => {
    button.addEventListener('click', function(event) {
      event.preventDefault();
      const id = this.getAttribute('data-id');
      document.getElementById('delete-id').value = id;
      showModal(modalDelete);
    });
  });
});
