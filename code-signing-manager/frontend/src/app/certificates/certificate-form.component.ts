import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ApiService } from '../core/api.service';

@Component({
  selector: 'app-certificate-form',
  templateUrl: './certificate-form.component.html'
})
export class CertificateFormComponent {
  msg = '';
  loading = false;

  form = this.fb.group({
    certificateName: ['', Validators.required],
    issuerName: ['', Validators.required],
    validFrom: ['', Validators.required],
    validTo: ['', Validators.required]
  });

  constructor(private fb: FormBuilder, private api: ApiService) {}

  submit() {
    if (this.form.invalid) return;
    this.loading = true;
    this.api.createCertificate(this.form.value).subscribe({
      next: () => {
        this.msg = '✅ Certificate created successfully.';
        this.form.reset();
        this.loading = false;
      },
      error: (e) => {
        this.msg = '❌ ' + (e?.error?.error || e?.error || 'Failed to create.');
        this.loading = false;
      }
    });
  }
}
