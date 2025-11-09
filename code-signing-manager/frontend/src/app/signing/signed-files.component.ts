import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ApiService } from '../core/api.service';

@Component({
  selector: 'app-sign-file',
  templateUrl: './sign-file.component.html'
})
export class SignFileComponent implements OnInit {
  certs: any[] = [];
  msg = '';
  loading = false;

  form = this.fb.group({
    fileName: ['', Validators.required],
    certificateId: ['', Validators.required]
  });

  constructor(private fb: FormBuilder, private api: ApiService) {}

  ngOnInit(): void {
    this.api.listCertificates().subscribe({
      next: (d) => this.certs = d,
      error: () => this.msg = 'Failed to load certificates'
    });
  }

  submit() {
    if (this.form.invalid) return;
    this.loading = true;
    this.api.signFile(this.form.value).subscribe({
      next: () => { this.msg = '✅ File signed successfully.'; this.form.reset(); this.loading = false; },
      error: (e) => { this.msg = '❌ ' + (e?.error?.error || e?.error || 'Failed to sign'); this.loading = false; }
    });
  }
}
