import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { CertificateFormComponent } from './certificates/certificate-form.component';
import { CertificateListComponent } from './certificates/certificate-list.component';
import { SignFileComponent } from './signing/sign-file.component';
import { SignedFilesComponent } from './signing/signed-files.component';

@NgModule({
  declarations: [
    AppComponent,
    CertificateFormComponent,
    CertificateListComponent,
    SignFileComponent,
    SignedFilesComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
