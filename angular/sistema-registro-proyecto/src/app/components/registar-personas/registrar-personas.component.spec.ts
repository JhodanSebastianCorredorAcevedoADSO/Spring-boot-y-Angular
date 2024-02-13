import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistarPersonasComponent } from './registrar-personas.component';

describe('RegistarPersonasComponent', () => {
  let component: RegistarPersonasComponent;
  let fixture: ComponentFixture<RegistarPersonasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistarPersonasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RegistarPersonasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
