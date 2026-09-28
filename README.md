# 📱 Lista de Contactos

Uma aplicação móvel nativa para Android desenvolvida para a gestão, armazenamento e visualização de contactos. Construído com foco em usabilidade e estruturação, o projeto explora a criação de interfaces dinâmicas e a integração de serviços remotos da Google (Firebase).   

*Desenvolvido em contexto académico na Universidade Politécnica do Cávado e do Ave (IPCA).*

## ✨ Funcionalidades

* **Lista de Contactos:** Ecrã principal (`MainActivity.kt`) que apresenta de forma clara e dinâmica todos os registos guardados, utilizando componentes visuais personalizados (`contact_row.xml`).   
* **Adição de Registos:** Ecrã dedicado (`AddActivity.kt`) com um formulário focado na introdução e gravação de novos contactos no sistema (`activity_add.xml`).   
* **Gestão de Dados na Cloud:** Integração configurada com o ecossistema Firebase (através do ficheiro `google-services.json`) para assegurar a persistência e o acesso remoto aos dados da aplicação.   
* **Modelo de Dados:** Entidade estruturada através da classe modelo `Contacto.kt` para garantir a integridade da informação transitada entre os ecrãs e a base de dados.   

## 🛠️ Tecnologias e Ferramentas

* **Linguagem Principal:** Kotlin   
* **Plataforma:** Android SDK   
* **Cloud & Backend:** Firebase (Google Services)   
* **Interface (UI):** XML Android   
* **Build System:** Gradle (configurado com Kotlin DSL)
