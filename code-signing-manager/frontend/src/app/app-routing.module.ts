import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CertificateFormComponent } from './certificates/certificate-form.component';
import { CertificateListComponent } from './certificates/certificate-list.component';
import { SignFileComponent } from './signing/sign-file.component';
import { SignedFilesComponent } from './signing/signed-files.component';

const routes: Routes = [
  { path: '', redirectTo: 'certificates/new', pathMatch: 'full' },
  { path: 'certificates/new', component: CertificateFormComponent },
  { path: 'certificates', component: CertificateListComponent },
  { path: 'sign', component: SignFileComponent },
  { path: 'signed', component: SignedFilesComponent },
  { path: '**', redirectTo: 'certificates/new' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
